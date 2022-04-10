package com.qc.comparable;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    @SuppressWarnings("all")
    public static void main(String[] args) {
        List<Attendant> attendants = new ArrayList<>();
        attendants.add(new Attendant(23, "Adam"));
        attendants.add(new Attendant(1, "Anna"));
        attendants.add(new Attendant(42, "Błażej"));
        attendants.add(new Attendant(12, "Ewa"));

        // Sorting with Runner.sort();
        Collections.sort(attendants);
        logAttendants(attendants);
        Collections.reverse(attendants);
        logAttendants(attendants);

        // Sorting with Comparator
        Comparator<Attendant> attendantComparator = new Comparator<Attendant>() {
            @Override
            public int compare(Attendant o1, Attendant o2) {
                return o1.compareTo(o2);
            }
        };
        attendantComparator = (o1, o2) -> o1.compareTo(o2);
        attendantComparator = Comparator.naturalOrder();

        // Old sorting by Runner.sort()
        Collections.sort(attendants, attendantComparator);
        // New sorting by List.sort();
        attendants.sort(attendantComparator);
        logAttendants(attendants);

        Collections.sort(attendants, Comparator.comparing(Attendant::getName));
        logAttendants(attendants);
    }

    private static void logAttendants(List<Attendant> attendants) {
        logger.info(Arrays.toString(attendants.toArray()));
    }
}
