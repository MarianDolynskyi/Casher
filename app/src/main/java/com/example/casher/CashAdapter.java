//package com.example.casher;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.TextView;
//
//import java.text.CollationElementIterator;
//import java.util.ArrayList;
//
//
//    class ProductAdapter extends CashAdapter<MoneyValue> {
//        private LayoutInflater inflater;
//        private int layout;
//        private ArrayList<MoneyValue> productList;
//
//        ProductAdapter(Context context, int resource, ArrayList<MoneyValue> products) {
//            super(context, resource, products);
//            this.productList = products;
//            this.layout = resource;
//            this.inflater = LayoutInflater.from(context);
//        }
//        public View getView(int position, View convertView, ViewGroup parent) {
//
//            final ViewHolder viewHolder;
//            if(convertView==null){
//                convertView = inflater.inflate(this.layout, parent, false);
//                viewHolder = new ViewHolder(convertView);
//                convertView.setTag(viewHolder);
//            }
//            else{
//                viewHolder = (ViewHolder) convertView.getTag();
//            }
//            final MoneyValue money = productList.get(position);
//
//            viewHolder.sectionView.setText(money.getSection());
//            viewHolder.SectionValueView.setText(formatValue(MoneyValue, product.getUnit()));
//
//            viewHolder.removeButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int count = product.getCount()-1;
//                    if(count<0) count=0;
//                    product.setCount(count);
//                    viewHolder.countView.setText(formatValue(count, product.getUnit()));
//                }
//            });
//            viewHolder.addButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int count = product.getCount()+1;
//                    product.setCount(count);
//                    viewHolder.countView.setText(formatValue(count, product.getUnit()));
//                }
//            });
//
//            return convertView;
//        }
//
//        private String formatValue(int count, String unit){
//            return String.valueOf(count) + " " + unit;
//        }
//        private class ViewHolder {
//            final TextView cashValueView, SectionValueView;
//            public CollationElementIterator sectionView;
//
//            ViewHolder(View view){
//                cashValueView = (TextView) view.findViewById(R.id.cashValues);
//                sectionValueView = (TextView) view.findViewById(R.id.sectionView);
//            }
//        }
//    }
//}
