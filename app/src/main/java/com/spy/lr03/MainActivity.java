package com.spy.lr03;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        List<String> data = createList();
        ListView list = findViewById(R.id.list);

        // Создаем объект адаптера
        MyAdapter adapter = new MyAdapter(this, data);

        // Передаем его виджету списка
        list.setAdapter(adapter);

        // Кнопка ADD
        findViewById(R.id.add).setOnClickListener(v -> {
            data.add(new Random()
                    .doubles(1, 0, 1000)
                    .mapToObj(String::valueOf)
                    .findFirst().get());
            adapter.notifyDataSetChanged();
        });

        // Кнопка DELETE
        findViewById(R.id.delete).setOnClickListener(v -> {
            data.remove(data.size() - 1);
            adapter.notifyDataSetChanged();
        });

        // Кнопка CLEAR
        findViewById(R.id.clear).setOnClickListener(v -> {
            data.clear();
            adapter.notifyDataSetChanged();
        });
    }

    private List<String> createList() {
        return new Random().doubles(25, 0, 1000)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
    }
}
