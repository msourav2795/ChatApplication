package com.application.chat.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.hazelcast.HazelcastSessionRepository;
import org.springframework.session.hazelcast.PrincipalNameExtractor;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapAttributeConfig;
import com.hazelcast.config.MapIndexConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@EnableHazelcastHttpSession 
@Configuration
public class HazelcastHttpSessionConfig {

        @Bean
        public HazelcastInstance hazelcastInstance() {
                MapAttributeConfig attributeConfig = new MapAttributeConfig()
                                .setName(HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE)
                                .setExtractor(PrincipalNameExtractor.class.getName());

                Config config = new Config();

                config.getMapConfig("spring:session:sessions") 
                                .addMapAttributeConfig(attributeConfig)
                                .addMapIndexConfig(new MapIndexConfig(
                                                HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE, false));

                return Hazelcast.newHazelcastInstance(config); 
        }

}
