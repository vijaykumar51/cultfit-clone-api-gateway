package com.cultclone.app.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * The Class CultFitCloneZuulApiGatewayApplication.
 */
@SpringBootApplication
@EnableZuulProxy
public class CultFitCloneZuulApiGatewayApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(CultFitCloneZuulApiGatewayApplication.class, args);
	}

}
