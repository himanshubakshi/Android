package com.himanshubakshi.funtvfacts;

/**
 * Created by hbakshi on 5/28/16.
 */

/**
 * Helper class for maintaining the TV Show data
 *
 */
public class ShowDataHelper {

    /**
     *
     * This helper method maps a show name to the corresponding string-array
     * which contains the show fun facts
     * @param showNameId
     * @return the corresponding string array id
     */
    public static int getShowDetailArrayId(int showNameId){
        int showDetailArrayId = -1;

        switch(showNameId)
        {
            case R.string.tvshow_name_friends:
                showDetailArrayId = R.array.tvshow_detail_friends;
                break;
            case R.string.tvshow_name_got:
                showDetailArrayId = R.array.tvshow_detail_got;
                break;
            case R.string.tvshow_name_himym:
                showDetailArrayId = R.array.tvshow_detail_himym;
                break;
            case R.string.tvshow_name_2_and_a_half_men:
                showDetailArrayId = R.array.tvshow_detail_2_and_a_half_men;
                break;
            case R.string.tvshow_name_tbbt:
                showDetailArrayId = R.array.tvshow_detail_tbbt;
                break;
        }
        return showDetailArrayId;
    }
}
