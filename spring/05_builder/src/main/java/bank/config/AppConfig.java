package bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class AppConfig {

    @Bean("connection1")
    public SSHConnection getSSHConnection1() {
        // you need to run install lombok plugin in your IDE
        // visit https://www.baeldung.com/lombok-ide
        return SSHConnection
                .builder()
                .username("tom")
                .disablePassword(true)
                .knownHost("host1")       // |
                .knownHost("host2")       // | ---> constructing set
                .knownHost("host3")       // |
                .node("workstation1")     // constructing list
                .signatureAlgorithm("ECDSA256", 256) // |
                .signatureAlgorithm("ECDSA384", 384) // | ---> constructing map
                .signatureAlgorithm("ECDSA521", 521) // |
                .validateKnownHosts(true)
                .build();
    }

    @Bean("connection2")
    public SSHConnection getSSHConnection2() {
        // you need to run install lombok plugin in your IDE
        // visit https://www.baeldung.com/lombok-ide

        // initialize mutable list
        List<String> nodes = new ArrayList<String>() {{
            add("workstation1");
            add("workstation2");
        }};

        // initialize mutable set
        Set<String> knownHosts = new HashSet<String>() {{
            add("host1");
            add("host2");
            add("host3");
        }};

        // initialize mutable map
        Map<String, Integer> signatureAlgorithms = new HashMap<String, Integer>() {{
            put("ECDSA256", 256);
            put("ECDSA384", 384);
            put("ECDSA521", 521);
        }};

        return SSHConnection
                .builder()
                .username("tom")
                .disablePassword(true)
                .signatureAlgorithms(signatureAlgorithms) // lombok converts mutable map to immutable map
                .knownHosts(knownHosts) // lombok converts mutable set to immutable set
                .nodes(nodes) // lombok converts mutable list to immutable list
                .validateKnownHosts(true)
                .build();
    }
}
