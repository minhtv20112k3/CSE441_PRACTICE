package com.example.th03;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.tvStudentName.setText(student.getFull_Name().first + " " + student.getFull_Name().last);
        holder.tvStudentId.setText(student.getId());
        holder.tvStudentGpa.setText(String.valueOf(student.getGpa()));

        // Thay đổi hình ảnh theo giới tính
        if ("Nữ".equals(student.getGender())) {
            holder.imgGender.setImageResource(R.drawable.ic_female);
        } else {
            holder.imgGender.setImageResource(R.drawable.ic_male);
        }
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        ImageView imgGender;
        TextView tvStudentName, tvStudentId, tvStudentGpa;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            imgGender = itemView.findViewById(R.id.imgGender);
            tvStudentName = itemView.findViewById(R.id.tvStudentName);
            tvStudentId = itemView.findViewById(R.id.tvStudentId);
            tvStudentGpa = itemView.findViewById(R.id.tvStudentGpa);
        }
    }
}
