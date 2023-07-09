package Yandex.contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cosmopolitism {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCountries = scanner.nextInt();
        Country[] countries = new Country[numberOfCountries];
        for (int i = 0; i < numberOfCountries; i++) {
            int name = i+1;
            int minIncome = scanner.nextInt();
            countries[i] = new Country(name, minIncome);
        }
        for (int i = 0; i < numberOfCountries; i++) {
            boolean educRequired = (scanner.nextInt() == 1);
            countries[i].setEducRequired(educRequired);
        }
        for (int i = 0; i < numberOfCountries; i++) {
            boolean canFamily = (scanner.nextInt() == 1);
            countries[i].setCanFamily(canFamily);
        }

        int Q = scanner.nextInt();

        Person[] people = new Person[Q];
        for (int i = 0; i < Q; i++) {
            int income = scanner.nextInt();
            people[i] = new Person(i,income);
        }

        for (int i = 0; i < Q; i++) {
            boolean hasEducation = (scanner.nextInt() == 1);
            people[i].setHasEducation(hasEducation);
        }

        for (int i = 0; i < Q; i++) {
            int parentsCitizenship = scanner.nextInt();
            people[i].setParentsCitizenship(parentsCitizenship);
        }
        List<Integer> countryList = new ArrayList<>();

        for (int i = 0; i < people.length; i++) {
            boolean flag=false;
            Person person = people[i];
            for (int j = 0; j < countries.length; j++) {
                Country country =countries[j];
                if (person.getIncome() == 0 && !person.isHasEducation()) {
                    if (country.getMinIncome() == 0 && !country.isEducRequired()||country.isCanFamily()&&person.getParentsCitizenship()==country.getName()) {
                        countryList.add(country.getName());
                        flag=true;
                        break;
                    }
                } else if ((person.getIncome() >= country.getMinIncome()) && (person.isHasEducation() || !country.isEducRequired())
                        || (country.isCanFamily()&& person.getParentsCitizenship() == country.getName())) {
                    countryList.add(country.getName());
                    flag=true;

                    break;
                } else if(j==countries.length-1&&!flag){
                    countryList.add(0);
                }
            }
        }

        for (int i = 0; i < countryList.size(); i++) {
            System.out.print(countryList.get(i)+" ");
        }
    }


    static class Country {
        private int name;
        private int minIncome;
        private boolean EducRequired;

        private boolean canFamily;

        public boolean isCanFamily() {
            return canFamily;
        }

        public void setCanFamily(boolean canFamily) {
            this.canFamily = canFamily;
        }

        public Country(int name, int minIncome) {
            this.name = name;
            this.minIncome = minIncome;
        }
        public int getName() {
            return name;
        }
        public int getMinIncome() {
            return minIncome;
        }
        public boolean isEducRequired() {
            return EducRequired;
        }

        public void setEducRequired(boolean educRequired) {
            this.EducRequired = educRequired;
        }

        @Override
        public String toString() {
            return name +
                    ", minIncome=" + minIncome +
                    EducRequired;
        }
    }
    static class Person {
        private int name;

        private int income;

        public Person(int name, int income) {
            this.name = name;
            this.income = income;
        }

        private boolean hasEducation;
        private int parentsCitizenship;
        public int getName() {
            return name;
        }

        public void setName(int name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return  " "+income +
                     hasEducation +
                     "" + parentsCitizenship
                    ;
        }

        public void setHasEducation(boolean hasEducation) {
            this.hasEducation = hasEducation;
        }

        public void setParentsCitizenship(int parentsCitizenship) {
            this.parentsCitizenship = parentsCitizenship;
        }

        public double getIncome() {
            return income;
        }
        public boolean isHasEducation() {
            return hasEducation;
        }
        public int getParentsCitizenship() {
            return parentsCitizenship;
        }
    }
    static class Classmate {
        private Person person;
        private Country country;
        public Classmate(Person person, Country country) {
            this.person = person;
            this.country = country;
        }
        public Person getPerson() {
            return person;
        }
        public Country getCountry() {
            return country;
        }
    }
}
