package org.bankaccount.customerservice.config;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "global.params")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class GlobalConfig {
    private int p1;
    private int p2;
}
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//
//@ConfigurationProperties(prefix = "global.params")
////@RefreshScope
////@EnableConfigurationProperties
//@Getter @Setter @AllArgsConstructor
//public Class GlobalConfig {
//private int p1;
//private int p2;
//}