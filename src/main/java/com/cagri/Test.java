package com.cagri;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        SehirManager sehirManager = new SehirManager();
//        System.out.println(sehirManager.sehirleriOlustur());
        List<Sehir> sehirList = sehirManager.sehirleriOlustur();


        System.out.println("===============SORU1-A====================");
        List<Sehir> bolgeList = sehirList.stream().filter(x -> x.getBolge().equals(EBolge.BOLGE_1)).toList();
        System.out.println(bolgeList);
        System.out.println("===============SORU1-B====================");
        List<String> bolgeListbyNames = sehirList.stream().filter(x -> x.getBolge().equals(EBolge.BOLGE_2)).map(y -> y.getIsim()).toList();
        System.out.println(bolgeListbyNames);


        System.out.println("===============SORU2====================");
        Set<String> plakaNoByNufus = sehirList.stream()
                .filter(x -> x.getNufus() > 150_000 && x.getNufus() < 600_000).map(y -> y.getPlakaNo()).collect(Collectors.toSet());
        System.out.println(plakaNoByNufus);


        System.out.println("===============SORU3-A====================");
        List<String> startsWithALetter = sehirList.stream().filter(x -> x.getIsim().startsWith("K")).map(y -> y.getIsim()).toList();
        System.out.println(startsWithALetter);
        System.out.println("===============SORU3-B====================");
        int lengthOfstartsWithALetter = sehirList.stream()
                .filter(x -> x.getIsim().startsWith("D")).mapToInt(x -> x.getIsim().length()).sum();
        System.out.println(lengthOfstartsWithALetter);


        System.out.println("===============SORU4====================");
        long sumOfNufus = sehirList.stream().mapToLong(x -> x.getNufus()).sum();
        System.out.println(sumOfNufus);


        System.out.println("===============SORU5====================");
        LongSummaryStatistics bolgeStatistics = sehirList.stream()
                .filter(x -> x.getBolge().equals(EBolge.BOLGE_3))
                .map(y -> y.getNufus()).collect(Collectors.summarizingLong(z -> z));
        System.out.println(bolgeStatistics);


        System.out.println("===============SORU6====================");
        double nufusByRangeStatistics = sehirList.stream()
                .filter(x -> x.getNufus() > 170_000 && x.getNufus() < 850_000)
                .map(y -> y.getNufus()).collect(Collectors.summarizingLong(z -> z)).getAverage();
        System.out.println(nufusByRangeStatistics);


        System.out.println("===============SORU7====================");
        sehirList.stream().filter(x -> x.getNufus() > 1_000_000).map(y -> y.getIsim()).forEach(System.out::println);


        System.out.println("===============SORU8====================");
        sehirList.stream().map(x -> x.getIsim().toUpperCase()).forEach(System.out::println);


        System.out.println("===============SORU9====================");
        List<Sehir> plakaWoddNumbers = sehirList.stream().filter(x -> Integer.parseInt(x.getPlakaNo()) % 2 == 1).collect(Collectors.toList());
        System.out.println(plakaWoddNumbers);


        System.out.println("===============SORU10====================");
        List<String> firsLetterWPlakaNo = sehirList.stream().map((x -> x.getPlakaNo() + "-" + x.getIsim().charAt(0))).collect(Collectors.toList());
        System.out.println(firsLetterWPlakaNo);
    }
}
