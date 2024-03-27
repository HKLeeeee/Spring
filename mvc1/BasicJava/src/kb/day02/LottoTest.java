package kb.day02;
import java.util.Arrays;

public class LottoTest {
	int lotto [] = new int [6];//0
    int cnt=0;//배열방에 중복없이 숫자가 들어간 개수.
    
    /**
     * 로또 번호 한개 생성하여 기존 로또번호와 비교하여 같으면 다시 생성.
     * */
    public void createLottoNo(){
        int lottoNo = (int)(Math.random() * 45) + 1;
        if(isCompareNo(lottoNo)){
            lotto[cnt] =lottoNo;
            cnt++;
            System.out.println(cnt+ " 중복없이 추가완료 : " + Arrays.toString(lotto));
        }

    }
    
    /**
     * 로또번호 비교하는 부분
	    return : true : 중복아님, false이면 중복 * */
    public boolean isCompareNo(int lottoNo ){
        for(int l : lotto){
            if (l==lottoNo){
                return false;
            }
        }
    	return true;
    }
    
    
    /**
     * 완성된 6개 번호 올림차순으로 정렬하기
     * */
     public void lottoSort(){
         Arrays.sort(lotto);
     }
     

     /**
      * 출력하는 메소드
      * */
     public void printLotto(){
     	for(int l : lotto){
            System.out.print(l + " ");
        }
     }
	
	public static void main(String[] args) {
		LottoTest lotto = new LottoTest();

		//로또번호를 중복없이 저장하는 메소드 소출
        while(lotto.cnt <6 ){
            lotto.createLottoNo();
        }
		System.out.println("--정렬하자 ----");
		//정렬호출
        lotto.lottoSort();
		
		//출력호출
	    lotto.printLotto();

	}
	

}
