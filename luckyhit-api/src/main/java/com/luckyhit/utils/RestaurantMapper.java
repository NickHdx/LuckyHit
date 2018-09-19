package com.luckyhit.utils;

import com.luckyhit.domain.*;
import com.luckyhit.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RestaurantMapper {
    @Autowired
    FlavorMapService flavorMapService;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    FlavorInfoService flavorInfoService;

    @Autowired
    OrderInfoService orderInfoService;

    @Autowired
    RestaurantInfoService restaurantInfoService;

    private Integer flavorCount;
    private List<FlavorMap> allFlavorMap;
    private List<FlavorInfo> allFlavorInfo;
    private Map<String, Map<Integer, Integer>> userFlavorWeight;

    public void init() {
        allFlavorInfo = flavorInfoService.getFlavorInfoList();
        flavorCount = allFlavorInfo.size();
        allFlavorMap = flavorMapService.getFlavorMapList();
        userFlavorWeight = calculateWeight();
    }

    public List<RestaurantInfo> mapRestaurant(UserInfo targetUser) {
        List<FlavorMap> flavorMapList = flavorMapService.getFlavorMapListByUserId(targetUser.getId());
        init();
        //the first time to login
//        if (flavorMapList == null || flavorMapList.size() <= 1) {
            Map<String, Double> similarityMap = new HashMap<>();
            List<UserInfo> userInfoList = userInfoService.getUserInfoList();
            for (UserInfo userInfo : userInfoList) {
                if (!userInfo.getId().equals(targetUser.getId())) {
                    double similarity = calculateSimilarity(userFlavorWeight.get(targetUser.getId()),
                            userFlavorWeight.get(userInfo.getId()));
                    similarityMap.put(userInfo.getId(), similarity);
                }
            }
            List<Map.Entry<String, Double>> sortedSimilarityMap = sortMap(similarityMap);

            //select first three Similarity
            Map<Integer, Integer> restaurantWeight = new HashMap<>();
            for (int i = 0; i < 3; i++) {
                List<OrderInfo> orderInfoList = orderInfoService.getOrderInfoListByFirstUserId(
                        sortedSimilarityMap.get(i).getKey()
                );
                for (OrderInfo orderInfo : orderInfoList) {
                    if (!restaurantWeight.containsKey(orderInfo.getRestaurantId())) {
                        restaurantWeight.put(orderInfo.getRestaurantId(), 0);
                    }
                    restaurantWeight.put(orderInfo.getRestaurantId(),
                            restaurantWeight.get(orderInfo.getRestaurantId()) + 1);
                }
            }
            List<Map.Entry<Integer, Integer>> sortedRestaurantWeight = sortMap2(restaurantWeight);

            //select first three restaurant
            List<RestaurantInfo> restaurantInfoList = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                restaurantInfoList.add(restaurantInfoService.getRestaurantInfoById(
                        sortedRestaurantWeight.get(i).getKey()
                ));
            }
            return restaurantInfoList;
//        } else {
//
//        }
//        return null;
    }

    public Map<String, Map<Integer, Integer>> calculateWeight() {
        Map<String, Map<Integer, Integer>> userFlavorWeight = new HashMap<>();
        for (FlavorMap flavorMap : allFlavorMap) {
            if (!userFlavorWeight.containsKey(flavorMap.getUserId())) {
                Map<Integer, Integer> weight = new HashMap<>();
                for (FlavorInfo flavorInfo : allFlavorInfo) {
                    weight.put(flavorInfo.getId(), 0);
                }
                userFlavorWeight.put(flavorMap.getUserId(), weight);
            }
            for (Integer flavorId : flavorMap.getFlavorList()) {
                userFlavorWeight.get(flavorMap.getUserId()).put(flavorId,
                        userFlavorWeight.get(flavorMap.getUserId()).get(flavorId) + 1);
            }
        }
        return userFlavorWeight;
    }

    public double calculateSimilarity(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        double sum = 0;
        for (Integer key : first.keySet()) {
            sum += Math.pow(first.get(key) - second.get(key), 2);
        }
        return Math.sqrt(sum);
    }

    public List<Map.Entry<String, Double>> sortMap(Map<String, Double> map) {
        List<Map.Entry<String, Double>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        return list;
    }

    public List<Map.Entry<Integer, Integer>> sortMap2(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        return list;
    }
}
