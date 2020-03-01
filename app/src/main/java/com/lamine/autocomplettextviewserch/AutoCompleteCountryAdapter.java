package com.lamine.autocomplettextviewserch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by Lamine MESSACI on 01/03/2020.
 */
public class AutoCompleteCountryAdapter  extends ArrayAdapter<CountryItem> {

    private List<CountryItem> mCountryFullListItems;

    public AutoCompleteCountryAdapter (@NonNull Context context, @NonNull List<CountryItem> countryList) {
        super (context, 0, countryList);
        mCountryFullListItems = new ArrayList<> (countryList);

    }

    @NonNull
    @Override
    public Filter getFilter () {
        return mFilter;
    }

    @NonNull
    @Override
    public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from (getContext ()).inflate (
                    R.layout.country_autocomplete_row, parent, false
            );
        }
        TextView textViewName = convertView.findViewById (R.id.text_view_name);
        ImageView imageViewFlag = convertView.findViewById (R.id.image_view_flag);

        CountryItem countryItem = getItem (position);

        if (countryItem != null){
            textViewName.setText (countryItem.getCountryName ());
            imageViewFlag.setImageResource (countryItem.getFlagImage ());
        }
        return convertView;
    }

    private Filter mFilter = new Filter () {
        @Override
        protected FilterResults performFiltering (CharSequence constraint) {
            FilterResults results = new FilterResults ();
            List<CountryItem> suggestions = new ArrayList<> ();

            if (constraint == null || constraint.length () == 0){
                suggestions.addAll (mCountryFullListItems);
            }else{
                String filterPatten = constraint.toString ().toLowerCase ().trim ();

                for (CountryItem item : mCountryFullListItems)
                    if (item.getCountryName ().toLowerCase ().contains (filterPatten)) {
                        suggestions.add (item);
                    }
            }

            results.values =suggestions;
            results.count = suggestions.size ();
            return results;

        }

        @Override
        protected void publishResults (CharSequence constraint, FilterResults results) {

            clear ();
            addAll ((List) results.values);
            notifyDataSetChanged ();
        }

        @Override
        public CharSequence convertResultToString (Object resultValue) {
            return ((CountryItem) resultValue).getCountryName ();
        }
    };

}
