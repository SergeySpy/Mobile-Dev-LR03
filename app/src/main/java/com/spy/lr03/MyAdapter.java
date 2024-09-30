package com.spy.lr03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<String> data;
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<String> data) {
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 1. Проверяем, есть ли у нас пункт списка для повторного использования
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item, parent, false);

        // 2. Получаем доступ к виджетам дерева объектов
        TextView number = convertView.findViewById(R.id.number);
        TextView text = convertView.findViewById(R.id.text);

        // 3. Меняем содержимое виджетов
        number.setText(String.valueOf(position));
        text.setText(data.get(position));

        // 4. Возвращаем модифицированное дерево объектов
        return convertView;
    }
}

