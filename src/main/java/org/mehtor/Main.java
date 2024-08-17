package org.mehtor;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * JSON: JavaScript Object Notation
 * Json : Hangi dili kullandığınız farketmeksizin vei taşımak için kullanılar ortak bir yapidir .
 * xml'e göre çok daha az boyut kapladığı için tercih edilmektedir.
 * Json sistemler arasında veri taşımaktadır.
 * {
     *     "ad":"Mehmet",
     *     "yas":24,
     *     "araba":null
     * }  ,//bu bir Json objesidir.
     *
     * {
     *      "ad":"Mehmet",
     *      "yas":24,
     *      "araba":null
     *  }
     *
 *  {} : Json Objesidir
 *  [] : Json Arrayidir
 *
 * API: Application Programming Interface
 */

/*
{
    "employees": [
    {"ad":"Selim", "soyad": "Tas", "maas":50000},
    {"ad":"Ayse", "soyad": "Tas", "maas":80000},
    {"ad":"Kenan", "soyad": "Tas", "maas":70000},
    ]
}

xml:
<employees>
    <employee>
    <ad> Selim </ad> <soyad> Tas </soyad> <maas> 50000 </maas>
    </employee>
    <employee>
    <ad> Ayse </ad> <soyad> Tas </soyad> <maas> 80000 </maas>
    </employee>
    <employee>
    <ad> Kenan </ad> <soyad> Tas </soyad> <maas> 70000 </maas>
    </employee>
<employees>

{
     "employees":["Selim","Ayse","Kenan"],
     "butce":5000000,
     "vergiBorcu": false,
     "sirket": null
}

 */
public class Main {
	public static void main(String[] args) {
		UserRepository repository = new UserRepository();
		repository.getUsers(200)
				.stream()
				.filter(user -> user.getLocation().getCountry().equalsIgnoreCase("Turkey"))
		          .forEach(user -> {
			System.out.println("Users arrayList.....:"+user);
		});
		//ödev: burada 10 farkli stream sorusu yazın çözün.
		
		//1) bölgesi finland olanlar
		System.out.println("####################################");
		System.out.println("\nFinland'daki userları getir");
		repository.getUsers(50).stream()
				.filter(user -> user.getLocation().getCountry().equalsIgnoreCase("finland"))
				.forEach(user->{
					System.out.println("Finland'daki userlar : "+user);
				});
		
		//2) Ankara sehrindeki user sayisini getir
		System.out.println("\"Ankara şehrindekideki userlarin sayisi");
		long count = repository.getUsers(50).stream()
		                       .filter(user -> user.getLocation().getCity().equalsIgnoreCase("Ankara")).count();
		System.out.println("Ankara sehrinde :"+count+ " user bulunuyor" );
		
		//3) Kullanıcılar arasında en yaşlı kişiyi bulun.
		System.out.println("\"Kullanıcılar arasında en yaşlı kişiyi bulun.");
		Optional<User> yasliKullanici = repository.getUsers(200).stream()
		                                .max(Comparator.comparingLong(user ->user.getDob().getAge()));
		yasliKullanici.ifPresent(user ->
				 System.out.print("\"En yaşlı kullanıcı adı : " + user.getName()));
		yasliKullanici.ifPresent(user ->
				 System.out.println("yasi: "+user.getDob().getAge()));
		
		//4)Kullanıcıların yaş ortalamasını hesaplayın.
		System.out.println("Kullanıcıların yaş ortalamasını: ");
		Double yasOrtalamasi = repository.getUsers(50).stream()
				.mapToLong(user -> user.getDob().getAge())
				.average().orElse(0);  //average ortalama alır.  orElse boş liste durumunda 0 döner
		System.out.println("Yaş ortalaması: " +yasOrtalamasi);
		
		//5)Kullanıcilarin hepsi 18 yaşından büyük mü kontrol et. allMatch()
		System.out.println("5)Kullanıcilarin hepsi 18 yaşından büyük mü kontrol etme : ");
		boolean herkesResitMi = repository.getUsers(50).stream()
				.allMatch(user -> user.getDob().getAge() >= 18);
		if (herkesResitMi){
			System.out.println("Tum kullanicilar 18 yasindan buyuk");
		}else {
			System.out.println("18 yasindan kucuk kullanicilar mevcut");
		}
		
		//6)Erkek kullanicilarin yas ortalamasi:
		System.out.println("Erkek kullanicilarin yas ortalamasi:");
		double erkeklerinYasOrtalamasi = repository.getUsers(50).stream()
				.filter(user -> user.getGender().equalsIgnoreCase("male"))
				.mapToLong(user->user.getDob().getAge())
				.average().orElse(0);
		System.out.println("erkeklerin Yas Ortalamasi: "+erkeklerinYasOrtalamasi);
		
		//7)İsim ve soyisimlerinin toplam uzunluğu 15 karakterden fazla olan kullanıcıları bulun ve bu kullanıcıların
		// tam adlarını büyük harfle yazdırın.
		System.out.println("soru 7 : ");
		repository.getUsers(20).stream()
				.filter(user -> user.getName().getFirst().length() + user.getName().getLast().length() >= 15)
				.map(user -> user.getName().getTitle().toUpperCase() +"."+ user.getName().getFirst().toUpperCase() +
						" "+ user.getName().getLast().toUpperCase())
				.forEach(System.out::println);
		
		//8)İsmi "A" harfi ile başlayan kullanıcıları filtreleyip listeyin.
		System.out.println("İsmi \"A\" harfi ile başlayan kullanıcılar listesi: ");
		repository.getUsers(50).stream()
				.filter(user -> user.getName().getFirst().startsWith("A"))
				.map(user -> user.getName().getTitle().toUpperCase() +"."+ user.getName().getFirst().toUpperCase() +" "+ user.getName().getLast().toUpperCase())
				  .forEach(System.out::println);
		
		//9)
	}
}