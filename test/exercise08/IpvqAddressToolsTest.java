package exercise08;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class IpvqAddressToolsTest {
    
    final static String TEST_FILE = "test/exercise08/ipvq-addresses.txt";

    static void printCollectionWithIndex(Collection<?> collection) {
        System.out.println("==== BEGIN");
        int index = 0;
        for (Object o : collection) {
            System.out.printf("%4d: %s%n", index, o);
            index++;
        }
        System.out.println("==== END");
    }

    @Test
    public void testReadFromFile() throws IOException {
        List<IpvqAddress> addressList = IpvqAddressTools.readFromFile(TEST_FILE);
        printCollectionWithIndex(addressList);

        Assert.assertEquals(100, addressList.size());

        Assert.assertEquals(new IpvqAddress("255;471;394;83;71"), addressList.get(0));
        Assert.assertEquals(new IpvqAddress("486;180;442;200;71"), addressList.get(1));
        Assert.assertEquals(new IpvqAddress("51;425;421;67;332"), addressList.get(2));
        Assert.assertEquals(new IpvqAddress("255;214;294;15;207"), addressList.get(3));
        Assert.assertEquals(new IpvqAddress("379;220;379;433;1"), addressList.get(4));
        Assert.assertEquals(new IpvqAddress("147;465;145;271;241"), addressList.get(5));
        Assert.assertEquals(new IpvqAddress("267;153;31;325;341"), addressList.get(6));
        Assert.assertEquals(new IpvqAddress("336;338;159;448;505"), addressList.get(7));
        Assert.assertEquals(new IpvqAddress("27;151;358;452;345"), addressList.get(8));
        Assert.assertEquals(new IpvqAddress("74;416;386;372;5"), addressList.get(9));

        Assert.assertEquals(new IpvqAddress("237;48;236;43;465"), addressList.get(98));
        Assert.assertEquals(new IpvqAddress("199;414;128;436;274"), addressList.get(99));
    }

    @Test
    public void testReadSorted() throws IOException {
        List<IpvqAddress> addressList = IpvqAddressTools.readFromFileSorted(TEST_FILE);
        printCollectionWithIndex(addressList);

        Assert.assertEquals(100, addressList.size());

        Assert.assertEquals(new IpvqAddress("0;92;28;395;317"), addressList.get(0));
        Assert.assertEquals(new IpvqAddress("0;443;353;420;259"), addressList.get(1));
        Assert.assertEquals(new IpvqAddress("1;1;1;1;1"), addressList.get(2));
        Assert.assertEquals(new IpvqAddress("1;1;1;1;1"), addressList.get(3));
        Assert.assertEquals(new IpvqAddress("1;1;1;1;1"), addressList.get(4));
        Assert.assertEquals(new IpvqAddress("2;2;2;2;2"), addressList.get(5));
        Assert.assertEquals(new IpvqAddress("2;2;2;2;2"), addressList.get(6));
        Assert.assertEquals(new IpvqAddress("10;1;1;1;1"), addressList.get(7));
        Assert.assertEquals(new IpvqAddress("10;1;1;1;2"), addressList.get(8));
        Assert.assertEquals(new IpvqAddress("10;1;1;2;1"), addressList.get(9));
        Assert.assertEquals(new IpvqAddress("10;1;2;1;1"), addressList.get(10));
        Assert.assertEquals(new IpvqAddress("10;2;1;1;1"), addressList.get(11));
        Assert.assertEquals(new IpvqAddress("11;1;1;1;1"), addressList.get(12));
        Assert.assertEquals(new IpvqAddress("16;213;143;374;485"), addressList.get(13));
        Assert.assertEquals(new IpvqAddress("21;379;55;216;244"), addressList.get(14));

        Assert.assertEquals(new IpvqAddress("499;502;177;7;355"), addressList.get(98));
        Assert.assertEquals(new IpvqAddress("508;276;415;30;412"), addressList.get(99));
    }

    @Test
    public void testReadWithoutDuplicates() throws IOException {
        Collection<IpvqAddress> addressesWithoutDuplicates =
                IpvqAddressTools.readFromFileWithoutDuplicates(TEST_FILE);
        printCollectionWithIndex(addressesWithoutDuplicates);

        Assert.assertEquals(96, addressesWithoutDuplicates.size());

        // wrap into List for easier access of elements
        List<IpvqAddress> addressList = new ArrayList<>(addressesWithoutDuplicates);

        Assert.assertEquals(new IpvqAddress("255;471;394;83;71"), addressList.get(0));
        Assert.assertEquals(new IpvqAddress("486;180;442;200;71"), addressList.get(1));

        Assert.assertEquals(new IpvqAddress("260;319;238;269;443"), addressList.get(90));
        Assert.assertEquals(new IpvqAddress("98;215;370;405;470"), addressList.get(91));
        Assert.assertEquals(new IpvqAddress("1;1;1;1;1"), addressList.get(92));
        Assert.assertEquals(new IpvqAddress("2;2;2;2;2"), addressList.get(93));
        Assert.assertEquals(new IpvqAddress("237;48;236;43;465"), addressList.get(94));
        Assert.assertEquals(new IpvqAddress("199;414;128;436;274"), addressList.get(95));
    }

    @Test
    public void testFindDuplicates() throws IOException {
        List<IpvqAddress> addressList = IpvqAddressTools.readFromFileSorted(TEST_FILE);
        Set<IpvqAddress> duplicates = IpvqAddressTools.findDuplicates(addressList);
        // Since duplicates is an (potentially unordered) set, we cannot make assumptions
        // on the order of the duplicates in the set. Thus, we test the size and that
        // it contains all elements, which will succeed no matter in which order the
        // elements are stored in the set
        System.out.println(duplicates);
        Assert.assertEquals(3, duplicates.size());
        Assert.assertTrue(duplicates.contains(new IpvqAddress("1;1;1;1;1")));
        Assert.assertTrue(duplicates.contains(new IpvqAddress("2;2;2;2;2")));
        Assert.assertTrue(duplicates.contains(new IpvqAddress("261;474;38;484;152")));
    }

    @Test
    public void testGetFirstComponentMap() throws IOException {
        List<IpvqAddress> addressList = IpvqAddressTools.readFromFileSorted(TEST_FILE);
        Map<Integer, Set<IpvqAddress>> byFirstComponent = IpvqAddressTools.getFirstComponentMap(addressList);

        Set<IpvqAddress> withFirstComponent1 = byFirstComponent.get(1);
        System.out.println("Addresses with first component == 1: " + withFirstComponent1);
        Assert.assertEquals(1, withFirstComponent1.size());
        Assert.assertTrue(withFirstComponent1.contains(new IpvqAddress("1;1;1;1;1")));

        Set<IpvqAddress> withFirstComponent10 = byFirstComponent.get(10);
        System.out.println("Addresses with first component == 10: " + withFirstComponent10);
        Assert.assertEquals(5, withFirstComponent10.size());
        Assert.assertTrue(withFirstComponent10.contains(new IpvqAddress("10;1;1;1;2")));
        Assert.assertTrue(withFirstComponent10.contains(new IpvqAddress("10;1;2;1;1")));
        Assert.assertTrue(withFirstComponent10.contains(new IpvqAddress("10;1;1;2;1")));
        Assert.assertTrue(withFirstComponent10.contains(new IpvqAddress("10;2;1;1;1")));
        Assert.assertTrue(withFirstComponent10.contains(new IpvqAddress("10;1;1;1;1")));

        Set<IpvqAddress> withFirstComponent288 = byFirstComponent.get(288);
        System.out.println("Addresses with first component == 288: " + withFirstComponent288);
        Assert.assertEquals(0, withFirstComponent288.size());
    }
}