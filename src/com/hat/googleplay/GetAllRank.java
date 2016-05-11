package com.hat.googleplay;

public class GetAllRank {

	public static void main(String[] args) {
		String packageName ="com.energysh.drawshow";
		String categoryName = ApkCategory.COMICS.getName();
		boolean isFree = true;
		
		int rank = TopFree.getRank(packageName, categoryName, isFree);
		System.out.println(rank);
//		
//		new GetKoreanRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
//		new GetJapaneseRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
//		new GetEnglishRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
//		new GetTraditionalChineseRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
//		new GetIndonesianRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
//		new GetThaiRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
//		new GetRussianRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
//		new GetArabicRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
//		new GetSpanishRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
//		new GetPortugueseRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
//		new GetFrenchRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
//		new GetSimpleChineseRank().getRank("com.energysh.drawshow", ApkCategory.COMICS.getName(), true);
//		
		
		GetKeywordRank.getRank("d:\\keyword.txt", packageName, categoryName, isFree);
		
		System.out.println(" -------------- finish --------------------");
	}
	
}
