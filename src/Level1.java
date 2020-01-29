import java.util.*;

public class Level1 {

    public static String[] ShopOLAP(int N, String[] items) {
        //создаем мапу "товар"-"колво продаж"
        Map<String, Integer> mapRes = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String[] tempAr = items[i].split(" ");
            int tempInt = Integer.parseInt(tempAr[1]);
            // складываем значения повторяющихся ключей
            if (mapRes.containsKey(tempAr[0])) {
                tempInt += mapRes.get(tempAr[0]);
            }
            mapRes.put(tempAr[0], tempInt);
        }
        int M = mapRes.size();
        String[] arRes = new String[M];
        String[] arResStr = new String[M];
        Integer[] arResInt = new Integer[M];
        int i = 0;
        for (Map.Entry<String, Integer> pair : mapRes.entrySet()) {
            arResStr[i] = pair.getKey();
            arResInt[i] = pair.getValue();
            i++;
        }
        int tempMax;
        String tempStr;
        for (i = 0; i < M; i++) {
            tempMax = arResInt[i];
            tempStr = arResStr[i];
            for (int j = i + 1; j < M; j++) {
                if (arResInt[j] > tempMax) {
                    arResInt[i] = arResInt[j];
                    arResStr[i] = arResStr[j];
                    arResInt[j] = tempMax;
                    arResStr[j] = tempStr;
                    tempMax = arResInt[i];
                    tempStr = arResStr[i];
                }
            }
            arRes[i] = arResStr[i] + " " + arResInt[i];
        }
        return arRes;
    }
}