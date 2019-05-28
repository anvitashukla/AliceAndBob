
import java.util.*;

public class AliceNBob {

	public static void main(String[] args) {
		int[] A = {6, 1, 4, 6, 3, 2, 7, 4};
		int K = 3;
		int L = 2;
		int sum = solution(A, K, L);
		System.out.println(sum);

	}
	
	static int solution(int[] A, int K, int L){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i =0;i<A.length-K+1;i++){
			int sum = 0;
			for(int j=i;j<K+i;j++){
				sum+=A[j];
			}
			map.put(i,sum);
		}
		
		int maxValue = Collections.max(map.values());
		List<Integer> key = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	        if (Objects.equals(maxValue, entry.getValue())) {
	            key.add(entry.getKey());
	        }
	    }
		System.out.println("key is "+key);
		int[] temp = A;
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		List<Integer> sums = new ArrayList<Integer>();
		
		for(int k=0;k<key.size();k++){
			for(int i=key.get(k);i<key.get(k)+K;i++){
				temp[i] = 0;
			}
			for(int i = 0;i<temp.length-L+1;i++){
				int sum = 0;
				for(int j=i;j<L+i;j++){
					sum+=temp[j];
				}
				map2.put(i,sum);
			}
			int maxValue2 = Collections.max(map2.values());
			sums.add(maxValue2+maxValue);
		}
				
		return Collections.max(sums);
	}

}
