package ex04_quiz;

interface Tour {
	public abstract void sightseeing();
	public abstract void leisure();
}

class GuamTour implements Tour {
	@Override
	public void sightseeing() {
		System.out.println("투몬비치 여행");		
	}
	@Override
	public void leisure() {
		System.out.println("패들보드 타기");
	}
}

class KoreaTour implements Tour {
	@Override
	public void sightseeing() {
		System.out.println("광화문 여행");		
	}
	@Override
	public void leisure() {
		System.out.println("한강유람선 타기");
	}
}

class TourGuide {
	private Tour tour;
	public TourGuide(Tour tour) {
		super();
		this.tour = tour;
	}
	public void sightseeing() {
		tour.sightseeing();
	}
	public void leisure() {
		tour.leisure();
	}
}

public class Quiz02 {

	public static void main(String[] args) {
		
		GuamTour tour1 = new GuamTour();
		KoreaTour tour2 = new KoreaTour();
		
		TourGuide guide1 = new TourGuide(tour1);
		TourGuide guide2 = new TourGuide(tour2);
		
		guide1.sightseeing();  // 투몬비치 여행
		guide1.leisure();  // 패들보드 타기
		
		guide2.sightseeing();  // 광화문 여행
		guide2.leisure();  // 한강유람선 타기

	}

}