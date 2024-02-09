package b01b.e1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

public class TimeSheetFactoryImpl implements TimeSheetFactory{

    private static List<String> createActivities(int numActivities, String str) {
        return Stream.iterate(1, i -> i + 1 ).map(i -> str +i ).limit(numActivities).collect(Collectors.toList());
    }

    private static List<String> createdays(int numDays, String str) {
        return Stream.iterate(1, i -> i + 1 ).map(i -> str + i ).limit(numDays).collect(Collectors.toList());
    }

    @Override
    public TimeSheet flat(int numActivities, int numNames, int hours) {
        return new TimeSheet() {

            List<String> activities = createActivities(numActivities, "act");
            List<String> days = createdays(numNames, "day");

            @Override
            public List<String> activities() {
                return activities;
            }

            @Override
            public List<String> days() {
                return days;
            }

            @Override
            public int getSingleData(String activity, String day) {
                return activities.contains(activity) && days.contains(day) ? 1 : 0;
            }

            @Override
            public Map<String, Integer> sumsPerActivity() {
                return activities.stream()
                        .map(act -> new Pair<>(act, days.stream()
                            .map(day -> hours)
                            .collect(Collectors.summingInt(i->i))))
                        .collect(Collectors.toMap(Pair::get1, Pair::get2));
            }

            @Override
            public Map<String, Integer> sumsPerDay() {
                return days.stream()
                        .map(day -> new Pair<>(day, activities.stream()
                            .map(act -> hours)
                            .collect(Collectors.summingInt(i->i))))
                        .collect(Collectors.toMap(Pair::get1, Pair::get2));
            }
            
        };
    }

    @Override
    public TimeSheet ofListsOfLists(List<String> activities, List<String> days, List<List<Integer>> data) {
        return new TimeSheet() {

            @Override
            public List<String> activities() {
                return createActivities(activities.size(), "a");
            }

            @Override
            public List<String> days() {
                return createdays(days.size(), "d");
            }

            @Override
            public int getSingleData(String activity, String day) {
                return activities.contains(activity) && days.contains(day) ? data.get(activities.indexOf(activity)).get(days.indexOf(day)) : 0;
            }

            @Override
            public Map<String, Integer> sumsPerActivity() {
                return activities.stream()
                        .map(a -> new Pair<>(a, days.stream())
                            .map(d -> new Pair<>(d, hours)
                            .collect(Collectors.summingInt(i->i))))
                        .collect(Collectors.toMap(Pair::get1, Pair::get2));

            }

            @Override
            public Map<String, Integer> sumsPerDay() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'sumsPerDay'");
            }
            
        };
    }

    @Override
    public TimeSheet ofRawData(int numActivities, int numDays, List<Pair<Integer, Integer>> data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ofRawData'");
    }

    @Override
    public TimeSheet ofPartialMap(List<String> activities, List<String> days, Map<Pair<String, String>, Integer> data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ofPartialMap'");
    }

}
