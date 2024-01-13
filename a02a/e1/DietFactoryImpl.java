package a02a.e1;

import java.util.Map;

import a02a.sol1.Diet;
import a02a.sol1.DietFactory;
import java.util.HashMap;

public class DietFactoryImpl implements DietFactory {

    @Override
    public Diet standard() {
        return new Diet() {

            private Map<String, Map<Nutrient, Integer>> map = new HashMap<>();

            @Override
            public void addFood(String name, Map<Nutrient, Integer> nutritionMap) {
                map.put(name, nutritionMap);
            }

            @Override
            public boolean isValid(Map<String, Double> dietMap) {
                Double totalCalories = 0.;
                for (var elem : dietMap.entrySet()) {
                    totalCalories += (map.get(elem.getKey()).values().stream().mapToDouble(i->i).sum() *elem.getValue()/100);
                }
                return totalCalories>=1500 && totalCalories<=2000;
            }
            
        };
    }

    @Override
    public Diet lowCarb() {
        return new Diet() {

            private Map<String, Map<Nutrient, Integer>> map = new HashMap<>();

            @Override
            public void addFood(String name, Map<Nutrient, Integer> nutritionMap) {
                map.put(name, nutritionMap);
            }

            @Override
            public boolean isValid(Map<String, Double> dietMap) {
                Double totalCalories = 0.;
                Double totalCarb = 0.;
                for (var elem : dietMap.entrySet()) {
                    totalCalories += (map.get(elem.getKey()).values().stream().mapToDouble(i->i).sum() *elem.getValue()/100);
                    totalCarb += map.get(elem.getKey()).get(Nutrient.CARBS);
                }
                return totalCalories>=1000 && totalCalories<=1500 && totalCarb<=300;
            }
            
        };
    }

    @Override
    public Diet highProtein() {
        return new Diet() {

            private Map<String, Map<Nutrient, Integer>> map = new HashMap<>();

            @Override
            public void addFood(String name, Map<Nutrient, Integer> nutritionMap) {
                map.put(name, nutritionMap);
            }

            @Override
            public boolean isValid(Map<String, Double> dietMap) {
                Double totalCalories = 0.;
                Double totalCarb = 0.;
                Double totalProtein = 0.;
                for (var elem : dietMap.entrySet()) {
                    totalCalories += (map.get(elem.getKey()).values().stream().mapToDouble(i->i).sum() *elem.getValue()/100);
                    totalCarb += map.get(elem.getKey()).get(Nutrient.CARBS);
                    totalProtein += map.get(elem.getKey()).get(Nutrient.PROTEINS);
                }
                return totalCalories>=2000 && totalCalories<=2500 && totalCarb<=300 && totalProtein>=1300;
            }
            
        };
    }

    @Override
    public Diet balanced() {
        return new Diet() {

            private Map<String, Map<Nutrient, Integer>> map = new HashMap<>();

            @Override
            public void addFood(String name, Map<Nutrient, Integer> nutritionMap) {
                map.put(name, nutritionMap);
            }

            @Override
            public boolean isValid(Map<String, Double> dietMap) {
                Double totalCalories = 0.;
                Double totalCarb = 0.;
                Double totalProtein = 0.;
                Double totalFat = 0.;
                for (var elem : dietMap.entrySet()) {
                    totalCalories += (map.get(elem.getKey()).values().stream().mapToDouble(i->i).sum() *elem.getValue()/100);
                    totalCarb += map.get(elem.getKey()).get(Nutrient.CARBS);
                    totalProtein += map.get(elem.getKey()).get(Nutrient.PROTEINS);
                    totalFat += map.get(elem.getKey()).get(Nutrient.FAT);
                }
                return totalCalories>=1600 && totalCalories<=2000 && totalCarb>=600 && totalProtein>=600 && totalFat>=400 && (totalProtein+totalFat<=1100);
            }
            
        };
    }

}
