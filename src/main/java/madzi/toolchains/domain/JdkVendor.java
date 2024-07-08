package madzi.toolchains.domain;

import java.util.stream.Stream;

/**
 * @author de
 */
public enum JdkVendor {
    CORRETTO("Corretto", new String[]{"amzn"}),
    DRAGON_WELL("Dragonwell", new String[]{"alibaba"}),
    GLUON("Gluon", new String[]{"gln"}),
    GRAAL_VM("GraalVM", new String[]{"grl", "graal"}),
    JAVA_NET("Java.net", new String[]{"open"}),
    LIBERICA("Liberica", new String[]{"librca"}),
    LIBERICA_NIK("LibericaNIK", new String[]{"nik"}),
    MANDREL("Mandrel", new String[]{"mandrel"}),
    MICROSOFT("Microsoft", new String[]{"ms"}),
    ORACLE("Oracle", new String[]{"oracle"}),
    SAP_MACHINE("SapMachine", new String[]{"sapmchn"}),
    SEMERU("Semeru", new String[]{"sem"}),
    TEMURIN("Temurin", new String[]{"tem"}),
    TRAVA("Trava", new String[]{"trava"}),
    ZULU("Zulu", new String[]{"zulu"});

    private final String vendor;
    private final String[] identifier;

    JdkVendor(final String vendor, final String[] identifier) {
        this.vendor = vendor;
        this.identifier = identifier;
    }

    public String vendor() {
        return vendor;
    }

    public String[] identifier() {
        return identifier;
    }

    public static JdkVendor parse(final String suffix) {
        if (null == suffix) {
            throw new IllegalArgumentException("The suffix cannot be NULL");
        }
        return Stream.of(values())
                .filter(jdk -> Stream.of(jdk.identifier()).anyMatch(id -> id.equalsIgnoreCase(suffix)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unable to parse unknown identifier: " + suffix));
    }
}
