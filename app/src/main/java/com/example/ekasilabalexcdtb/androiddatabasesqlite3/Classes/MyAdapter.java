package com.example.ekasilabalexcdtb.androiddatabasesqlite3.Classes;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ekasilabalexcdtb.androiddatabasesqlite3.R;

import java.util.List;

/**
 * Created by eKasiLab Alex CDTB on 14 Nov 2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    List<Person> personList;

    public MyAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_main, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Person person = personList.get(position);
        holder.txtName.setText(person.getName());
        holder.txtSurname.setText(person.getSurname());
        holder.txtGender.setText(person.getGender());
        holder.txtIdNumber.setText(person.getIdNumber());
        holder.txtAge.setText(person.getAge());

        //Delete the database
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper = new DBHelper(context);

                dbHelper.deletePerson(holder.txtIdNumber.getId());
                personList.remove(position);
                notifyDataSetChanged();
                Toast.makeText(context, "Table deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtSurname, txtGender, txtIdNumber, txtAge;
        CardView cardView;

        public MyViewHolder(View view) {
            super(view);

            txtName = (TextView) view.findViewById(R.id.txtName);
            txtSurname = (TextView) view.findViewById(R.id.txtSurname);
            txtGender = (TextView) view.findViewById(R.id.txtGender);
            txtIdNumber = (TextView) view.findViewById(R.id.txtIdNumber);
            txtAge = (TextView) view.findViewById(R.id.txtAge);
            cardView = (CardView) view.findViewById(R.id.card_view);
        }
    }
}
