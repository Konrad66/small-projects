package org.example.advanced.exe6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Town {

    private List<Citizen> citizens = new ArrayList<>();

    public void add(Citizen citizen) {
        citizens.add(citizen);
    }

    public int howManyCanVote() {
        int canVote = 0;
        for (Citizen citizen : citizens) {
            if (citizen.canVote()) {
                canVote++;
            }
        }
        return canVote;
    }

    public List<String> whoCanVote() {
        List<String> names = new ArrayList<>();
        for (Citizen citizen : citizens) {
            if (citizen.canVote()) {
                names.add(citizen.getName());
                System.out.println(citizen.getName());
            }
        }
        System.out.println(names);
        return names;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Town town)) return false;
        return Objects.equals(citizens, town.citizens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(citizens);
    }
}
