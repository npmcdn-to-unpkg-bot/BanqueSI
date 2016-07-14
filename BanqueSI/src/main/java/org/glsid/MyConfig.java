package org.glsid;

import org.glsid.rmi.BanqueRmiRemote;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class MyConfig {
	@Bean
	public SimpleJaxWsServiceExporter getJWS() {
		SimpleJaxWsServiceExporter exporter= new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://localhost:8089/MaBanque");
		return exporter;
		
	}
	@Bean
	public RmiServiceExporter getRmiService(ApplicationContext ctx) {
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setService(ctx.getBean("myRmiService"));
		exporter.setRegistryPort(1099);
		exporter.setServiceName("BK");
		exporter.setServiceInterface(BanqueRmiRemote.class);
		return exporter;
		
		
	}
}
