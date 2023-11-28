package exercise05;

public class EmailRegex {

    public static final String EMAIL_REGEX = "[^\\s@]+@[^\\s@]+\\.[^\\s@]{2,}";
    // keine Whitespace Zeichen (\\s) und kein @ in Benutzername und Domain
    // @ trennt Benutzernamen von der Domain
    // \\. trennt die Domain von der top level domain
    // {2,} teil hinter dem letzten Punkt ist mindestens 2 Zeichen lang
    // benutzername@domain.topdomain
    // [^\s@] steht für beliebig viele Zeichen vor dem @
    // +: min 1 Zeichen bis n Länge (gehört zu dem Kommentar davor)
    // das @ selbst steht für @
    // \\ Trennung und danach kommt der Punkt, der . steht für den tatsächlichen


}
