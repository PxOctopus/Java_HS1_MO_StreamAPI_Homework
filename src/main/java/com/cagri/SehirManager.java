package com.cagri;

import javax.print.attribute.standard.SheetCollate;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.getInteger;
import static java.lang.Integer.parseInt;

public class SehirManager {
    List<Sehir> sehirList = new ArrayList<>();
    Sehir sehir;
    Random random = new Random();


    public List<Sehir> sehirleriOlustur() {
        String[] sehirIsimleri = SehirDatabase.iller;

        for (int i = 0; i < sehirIsimleri.length; i++) {
            String sehirAdi = sehirIsimleri[random.nextInt(sehirIsimleri.length)];
            long nufus = random.nextLong(100_000, 5_000_000);
            int plakaNo = i + 1;
            String sPlakaNo = (plakaNo < 10) ? "0" + plakaNo : String.valueOf(plakaNo);
            EBolge bolge = EBolge.values()[random.nextInt(EBolge.values().length)];

            Sehir sehir = new Sehir(sehirAdi, nufus, sPlakaNo, bolge);
            sehirList.add(sehir);
        }

        return sehirList;
    }

}


