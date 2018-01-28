package jaz.dusunapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class DictionaryFragment extends Fragment {

    private FragmentListener listener;
    private String value = "Hello everyone!!!";
    ArrayAdapter<String> adapter;
    ListView dicList;
    public DictionaryFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dictionary, container, false);
    }

    //from dictionary fragment view button to handle event
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*Button myButton = (Button)view.findViewById(R.id.myBtn);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null)
                listener.onItemClick(value);
            }
        });*/

        dicList = view.findViewById(R.id.dictionaryList);
        //i assumed since dictionary is a lot of words, thus array of words is needed hence
        //array adapter
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,getListofWords());
        dicList.setAdapter(adapter);

        //this handles whenever a specific word is clicked
        //user is directed to detailfragment
        dicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(listener!=null)
                listener.onItemClick(getListofWords()[position]);
            }
        });
    }

    //to reset the dictionary when choose another language
    public void resetDataSource(String[] source){
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,source);
        dicList.setAdapter(adapter);
    }

    //method for filtering string in the search bar
    public void filterValue(String value){
        //adapter.getFilter().filter(value);
        int size = adapter.getCount();
        for (int i = 0; i<size;i++){
            if(adapter.getItem(i).startsWith(value)){
               dicList.setSelection(i);
               break;
            }
        }
    }

    String[] getListofWords(){
        String[] source = new String[]{
                "abad"
                ,"abadi"
                ,"abang"
                ,"abuk"
                ,"ada"
                ,"acar"
                ,"acara"
                ,"acuan"
                ,"adat"
                ,"adik"
                ,"adil"
        };
        return source;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void setOnFragmentListener(FragmentListener listener){
        this.listener = listener;

    }

}
