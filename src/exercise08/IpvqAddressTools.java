package exercise08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class IpvqAddressTools {

    private IpvqAddressTools() {
        //static utility class
    }

    /**
     * This method reads a file with IPvQ addresses where each line contains one address.
     *
     * @param fileName      it is not checked that the filename is not {@code null}
     * @return              A list of the addresses in the same order as in the file
     * @throws IOException  if some I/O error occurs (e.g. file not existent)
     */
    public static List<IpvqAddress> readFromFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);
        // now, have a list "lines" with all the addresses as strings
        // you can uncomment this to see how the list looks like:
        //System.out.println(lines);

        // TODO: convert lines to a list of type IpvqAddress
        List<IpvqAddress> addresses = new ArrayList<>();
        for (String line : lines) {
            IpvqAddress address = new IpvqAddress(line);
            addresses.add(address);
        }
        return addresses;
    }

    /**
     * This method reads a file with IPvQ addresses where each line contains one address.
     *
     * @param fileName      it is not checked that the filename is not {@code null}
     * @return              A list of the addresses sorted ascending
     * @throws IOException  if some I/O error occurs (e.g. file not existent)
     */
    public static List<IpvqAddress> readFromFileSorted(String fileName) throws IOException {
        // Hint: You can use readFromFile here, too
        List<IpvqAddress> addresses = readFromFile(fileName);
        addresses.sort(Comparator.naturalOrder());
        return addresses;
    }

    /**
     * This method reads a file with IPvQ addresses where each line contains one address.
     *
     * @param fileName      it is not checked that the filename is not {@code null}
     * @return              A list of the addresses in the same order as in the file, but with no duplicate
     *                      entries.
     * @throws IOException  if some I/O error occurs (e.g. file not existent)
     */
    public static Collection<IpvqAddress> readFromFileWithoutDuplicates(String fileName) throws IOException {
        // Hint 1: You can use readFromFile here, too
        // Hint 2: The implementation is very, very simple if you know the suitable Java collection to return...
        //         If this hint does not help you, implement it "the hard way" by iterating over the list
        List<IpvqAddress> addressList = readFromFile(fileName);
        return new LinkedHashSet<>(addressList);
    }

    /**
     * This method finds all entries in the given list that occur more than once.
     *
     * @param addresses the list to check
     * @return          a set of duplicates, can have any order
     */
    public static Set<IpvqAddress> findDuplicates(List<IpvqAddress> addresses) {
        Set<IpvqAddress> duplicates = new HashSet<>();
        Set<IpvqAddress> uniqueAddresses = new HashSet<>();
        for (IpvqAddress address : addresses) {
            if (!uniqueAddresses.add(address)) {
                duplicates.add(address);
            }
        }
        return duplicates;
    }

    /**
     * Returns a map that maps an integer from 0 to 511 to a set of all those addresses
     * from addressList that have this integer as first component.
     *
     * @param addressList
     * @return
     */
    public static Map<Integer, Set<IpvqAddress>> getFirstComponentMap(List<IpvqAddress> addressList) {
        // here, we construct a map that has an empty set for each place from 0 to 511
        Map<Integer, Set<IpvqAddress>> map = new HashMap<>();
        for (int i = 0; i < 512; i++) {
            map.put(i, new HashSet<>());
        }
        // Hint: What does map.get(0) return? And map.get(1)? ...
        // Iterate over all addresses and add them into the corresponding set.
        for (IpvqAddress address : addressList) {
            int firstComponent = address.getComponent1();
            Set<IpvqAddress> addressesWithFirstComponent = map.get(firstComponent);
            addressesWithFirstComponent.add(address);
        }
        return map;
    }
}
