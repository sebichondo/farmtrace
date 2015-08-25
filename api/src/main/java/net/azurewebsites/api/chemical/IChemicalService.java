package net.azurewebsites.api.chemical;

import com.squareup.otto.Bus;

/**
 * Created by sebichondo on 8/20/15.
 */
public interface IChemicalService {
    public void getChemicals(Bus bus);
}
