package com.example.jyo05.recyclerview;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Oh, Joon young (speldipn)
 * @Since: 2018-10-22
 */
public class CarDao {
  List<Car> list = new ArrayList<>();
  Context ctx;

  public CarDao(Context ctx) {
    this.ctx = ctx;
  }

  List<Car> getDao() {
    final int max = 100;
    for (int i = 0; i < max; ++i) {
      Car car = new Car();
      String carName;
      if (i % 2 == 0) {
        carName = "bmw3";
      } else {
        carName = "bmwm4";
      }
      car.imgId = ctx.getResources().getIdentifier(carName, "drawable", ctx.getPackageName());
      car.name = carName + "-" + String.format("%02d", i);
      car.company = "BMW";
      list.add(car);
    }

    return list;
  }
}

class Car {
  int imgId;
  String name;
  String company;
}