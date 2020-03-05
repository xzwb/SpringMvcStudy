package spittr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 在此之前的Spring Security 5.0的默认PasswordEncoder是NoOpPasswordEncoder其所需的明文密码。在Spring Security 5中，默认值为DelegatingPasswordEncoder，需要密码存储格式。
 * 解决方案1 –添加密码存储格式，对于纯文本，添加{noop}
 *
 * 上面这段话的意思是说，
 * 现如今Spring Security中密码的存储格式是“{id}…………”。
 * 前面的id是加密方式，id可以是bcrypt、sha256等，后面跟着的是加密后的密码。
 * 也就是说，程序拿到传过来的密码的时候，会首先查找被“{”和“}”包括起来的id，来确定后面的密码是被怎么样加密的，如果找不到就认为id是null。
 * 这也就是为什么我们的程序会报错：There is no PasswordEncoder mapped for the id “null”。
 * 官方文档举的例子中是各种加密方式针对同一密码加密后的存储形式，原始密码都是“password”
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER")
                .and().withUser("admin").password("{noop}password").roles("USER", "ADMIN");
    }

    /**
     * 错误的
     *
     * 密码存储格式
     * 密码的一般格式为：
     *  {id} encodedPassword
     *
     * 这样，“ id”是用于查找PasswordEncoder应使用的标识符，而“ encodedPassword”是所选对象的原始编码密码 PasswordEncoder。“ id”必须在密码的开头，以“ {”开头，以“}”结尾。如果找不到“ id”，则“ id”将为空。例如，以下可能是使用不同“ id”编码的密码列表。所有原始密码均为“密码”。
     *  {bcrypt} $ 2a $ 10 $ dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM / BG
     *  {noop}密码
     *  {pbkdf2} 5d923b44a6d129f3ddf3e3c8d29412723dcbde72445e8ef6bf3b508fbf17fa4ed4d6b99ca763d8dc
     *  {scrypt} $ e0801 $ 8bWJaSu2IKSn9Z9kM + TPXfOc / 9bdYSrN1oD9qfVThWEwdRTnO7re7Ei + fUZRJ68k9lTyuTeUp4of4g24hHnazw == $ OAOec05 + bXxVYu / 1QZ
     *  {sha256} 97cde38028ad898ebc02e690819fa220e88c62e0699403e94fff291cfffaf8410849f27605abcbc0
     *
     * 对于我们上面构建的DelegatingPasswordEncoder：
     * 第一个密码的PasswordEncoderID为“ bcrypt”，编码密码为“ $ 2a $ 10 $ dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM / BG”。匹配时将委托给 BCryptPasswordEncoder
     * 第二个密码的PasswordEncoderID为“ noop”，编码后的密码为“ password”。匹配时将委托给 NoOpPasswordEncoder
     * 第三个密码的PasswordEncoderID为“ pbkdf2”，编码密码为“ 5d923b44a6d129f3ddf3e3c8d29412723dcbde72445e8ef6bf3b508fbf17fa4ed4d6b99ca763d8dc”。匹配时将委托给Pbkdf2PasswordEncoder
     * 第四个密码的PasswordEncoderID为“ scrypt”，编码密码为“ $ e0801 $ 8bWJaSu2IKSn9Z9kM + TPXfOc / 9bdYSrN1oD9qfVThWEwdRTnO7re7Ei + fUZRJ68k9lTyuTeUp4f4YXYXVYXYXWYXWX1YXWX1YQWX1YQWXQ1YQUXWQ1YQUXWQ1XQ1YQ1DQ1DQ1DW1DQ1DW1DQ1D0W1D9 SCryptPasswordEncoder
     * 最终密码的PasswordEncoderID为“ sha256”，编码密码为“ 97cde38028ad898ebc02e690819fa220e88c62e0699403e94fff291cfffaf8410849f27605abcbc0”。匹配时将委托给StandardPasswordEncoder
     *
     *
     * 只有noop是原始密码
     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("{BCrypt}password").roles("USER")
//                .and().withUser("admin").password("{BCrypt}password").roles("USER", "ADMIN");
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and().authorizeRequests()
                .antMatchers("/home").authenticated()
                .anyRequest().permitAll();
    }
}
