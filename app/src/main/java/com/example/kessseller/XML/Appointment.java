package com.example.kessseller.XML;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kessseller.Adapter.AdapterAppointment;
import com.example.kessseller.ButtonSheet.BTSDataDetail;
import com.example.kessseller.ButtonSheet.BTSRequestDoctor;
import com.example.kessseller.Data.DataItemAppointment;
import com.example.kessseller.Data.DataViewAppointment;
import com.example.kessseller.Listener.ClickDetailRequestDoctor;
import com.example.kessseller.R;

import java.util.List;
import java.util.zip.Inflater;

public class Appointment extends DialogFragment {
    LinearLayout linearLayout;
    RecyclerView recyclerView;
    AlertDialog alertDialog;
    String[] app_values = {"All","Request","Accepted","Completed","Cancelled"};
    TextView textView;
    Context context;

    List<DataViewAppointment.DataAppointment>dataAppointments;

    @Override
    public int getTheme() {
        return R.style.AppBottomSheetDialogTheme;
    }

    private ClickDetailRequestDoctor clickDetailRequestDoctor = new ClickDetailRequestDoctor() {
        @Override
        public void itemClickdetailDoctor(DataViewAppointment.DataAppointment dataAppointment) {
            getTheme();
            BTSRequestDoctor btsRequestDoctor = new BTSRequestDoctor(context);
            btsRequestDoctor.show(getFragmentManager(), BTSRequestDoctor.class.getSimpleName());
        }
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.appointments,container,false);

        DataViewAppointment dataViewAppointment = new DataViewAppointment();
        dataAppointments = dataViewAppointment.getDataAppointments();
        recyclerView=(RecyclerView)view.findViewById(R.id.re_appointment);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);

        AdapterAppointment adapterAppointment = new AdapterAppointment(dataAppointments);
        recyclerView.setAdapter(adapterAppointment);
        adapterAppointment.setClickDetailRequestDoctor(clickDetailRequestDoctor);

        textView = view.findViewById(R.id.txt_appointment_filter);

        recyclerView = view.findViewById(R.id.re_appointment);

        linearLayout = view.findViewById(R.id.filter_appointment);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onCreateDialog(savedInstanceState);
            }
        });
        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Selected Filter");
        builder.setSingleChoiceItems(app_values,-1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                textView.setText(app_values[0]);
                TextView txt = (TextView) getActivity().findViewById(R.id.txt_appointment_filter);
                txt.setText(app_values[i]);
                dialogInterface.dismiss();
            }

        });builder.create();
        return builder.show();
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }
}
