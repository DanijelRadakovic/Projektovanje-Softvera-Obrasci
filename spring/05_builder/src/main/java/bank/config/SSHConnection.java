package bank.config;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;


import java.util.List;
import java.util.Map;
import java.util.Set;

@Builder
@Getter
public class SSHConnection {

    private String username;
    private String password;
    private boolean disablePassword;
    private boolean validateKnownHosts;
    @Singular
    private List<String> nodes;
    @Singular
    private Set<String> knownHosts;
    @Singular
    private Map<String, Integer> signatureAlgorithms;
}
