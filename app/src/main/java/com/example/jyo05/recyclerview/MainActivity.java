package com.example.jyo05.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

  RecyclerView recyclerview;
  public static final String LIST_NAME = "list_name";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    init();
  }

  private void init() {
    recyclerview = findViewById(R.id.recyclerView);
    CarDao dao = new CarDao(this);
    CustomAdapter adapter = new CustomAdapter(this, dao.getDao());
    recyclerview.setAdapter(adapter);
    recyclerview.setLayoutManager(new LinearLayoutManager(this));
  }
}

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Holder> {
  List<Car> list;
  Context ctx;
  View itemView;

  public CustomAdapter(Context ctx, List<Car> list) {
    this.ctx = ctx;
    this.list = list;
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    return new Holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false));
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int i) {
    Car car = list.get(i);
    holder.image.setImageResource(car.imgId);
    holder.name.setText(car.name);
    holder.company.setText(car.company);
    holder.itemView.startAnimation(AnimationUtils.loadAnimation(ctx, R.anim.translate));
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  class Holder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView name;
    TextView company;
    View itemView;

    public Holder(@NonNull View v) {
      super(v);
      image = v.findViewById(R.id.image);
      name = v.findViewById(R.id.name);
      company = v.findViewById(R.id.company);
      itemView = v;

      image.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent intent = new Intent(v.getContext(), DetailActivity.class);
          intent.putExtra(MainActivity.LIST_NAME, name.getText());
          ctx.startActivity(intent);
        }
      });
    }
  }
}
