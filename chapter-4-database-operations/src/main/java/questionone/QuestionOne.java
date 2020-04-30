package questionone;

import java.util.ArrayList;

public class QuestionOne {

	public static void main(String[] args) {
		

		ArrayList<Integer> ciftList = new ArrayList<Integer>();
		ArrayList<Integer> tekList = new ArrayList<Integer>();

		ArrayList<Integer> list = new ArrayList<Integer>();
		arrayDegerEkle(list);

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i < 2500; i++) {
					if (list.get(i) % 2 == 0) {
						ciftList.add(list.get(i));
					} else {
						tekList.add(list.get(i));
					}
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 2500; i < 5000; i++) {
					if (list.get(i) % 2 == 0) {
						ciftList.add(list.get(i));
					} else {
						tekList.add(list.get(i));
					}
				}
			}
		});

		Thread thread3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 5000; i < 7500; i++) {
					if (list.get(i) % 2 == 0) {
						ciftList.add(list.get(i));
					} else {
						tekList.add(list.get(i));
					}
				}
			}
		});

		Thread thread4 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 7500; i < 10000; i++) {
					if (list.get(i) % 2 == 0) {
						ciftList.add(list.get(i));
					} else {
						tekList.add(list.get(i));
					}
				}
			}
		});

		thread1.start();
		try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thread2.start();
		try {
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thread3.start();
		try {
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thread4.start();
		try {
			thread4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Çiftt Sayılar : ");
		listeyiYazdir(ciftList);
		
		System.out.println("tek Sayılar : ");
		listeyiYazdir(tekList);
	}

	public static void arrayDegerEkle(ArrayList<Integer> list) {

		for (int i = 1; i <= 10000; i++) {
			list.add(i);
		}
	}

	public static void listeyiYazdir(ArrayList<Integer> list) {
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
