package exercise05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpvqAddressFinder {

    //Aufgabe4
    public static void main(String[] args) {
        final String text = "1;186;462;423;40 ipsum dolor sit 118;469;228;363;507, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore 273;223;241;120 dolore magna aliquyam erat, sed diam voluptua. At vero eos 249;512;106;291;228 accusam 164;488;321;116 justo duo dolores 155;464;116;438 ea rebum. St276;177;77;486 clita kasd gubergren, no 465;246;36;417;405 takimata sanctus est 45;408;210;98;347 ipsum dolor sit 346;88;409;220;276. 313;323;329;372;131 ipsum dolor sit 437;460;80;450;350, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore 25;515;509;334;456 dolore magna aliquyam erat, sed diam voluptua. At vero eos 404;516;398;172;193 accusam 223;452;279;493 justo duo dolores 474;516;338;440;29 ea rebum. St27;325;415;394 clita kasd gubergren, no 510;30;383;179;471 takimata sanctus est 465;306;65;400;20 ipsum dolor sit 405;306;0;294;87. 188;373;95;124;315 ipsum dolor sit 347;94;301;7;128, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore 473;512;61;291;285 dolore magna aliquyam erat, sed diam voluptua. At vero eos 0;514;276;189;484 accusam 385;514;241;496;463 justo duo dolores 181;513;394;149;446 ea rebum. St187;516;159;322;69 clita kasd gubergren, no 137;13;119;93;156 takimata sanctus est 142;274;186;314;416 ipsum dolor sit 481;451;273;77;485. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros 391;377;372;27 accumsan 222;103;110;298 iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. 377;445;215;490;402 ipsum dolor sit 443;79;326;335;133.";
       // final String ipvqPattern = IpvqRegex.IPVQ_REGEX;
        final String ipvqPattern = "((([0-9]|[1-9][0-9]|[1-4][0-9][0-9]|50[0-9]|510|511);){4}([0-9]|[1-9][0-9]|[1-4][0-9][0-9]|50[0-9]|510|511))";

        Pattern pattern = Pattern.compile(ipvqPattern);
        Matcher matcher = pattern.matcher(text);

        int counter = 0;

        // TODO

        while (matcher.find()) {
            counter++;
        }

        System.out.println(counter);    //17
    }
}
