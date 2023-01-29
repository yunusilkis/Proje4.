package Veritabani;
import Modeller.Departmanlar.BilisimTeknolojileriDepartmani;
import Modeller.Departmanlar.Departman;
import Modeller.Departmanlar.İnsanKaynaklariDepartmani;
import Modeller.Departmanlar.YönetimDepartmani;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Departmanlar {
    // Bunu bir veritabani gibi düsünmeliyiz bu yüzden proje calistiği zaman, ilk once veritabani olusmali ki
    // ekleme cikarma islemlerini rahatca yapabilelim bu yüzden static verip, departmanList i ise
    // tanimlar iken new leyip, bu departmanlari içerisine attim.
    static private final Departman BILISIM_TEKLONOJILERI_DEPARTMANI = new BilisimTeknolojileriDepartmani();
    static private final Departman YONETIM_DEPARTMANI = new YönetimDepartmani();
    static private final Departman INSAN_KAYNAKLARI_DEPARTMANI = new İnsanKaynaklariDepartmani();
    static private List<Departman> DepartmanList = new ArrayList<>(Arrays.asList(BILISIM_TEKLONOJILERI_DEPARTMANI, YONETIM_DEPARTMANI, INSAN_KAYNAKLARI_DEPARTMANI));

    // Departman listesini alabilmek icin, ki bu liste üzerinde gezinip, zam oranlarini veya, calisanin
    // hangi departmanda olduğunu bulabilmek icin döngü ile beraber, tek tek departman kodlarina bakabilelim.
    public static List<Departman> getDepartmanList() {
        return DepartmanList;
    }


}
