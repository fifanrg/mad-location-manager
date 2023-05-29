package mad.location.manager.lib.locationProviders;

import android.content.Context;
import android.location.Location;

import androidx.annotation.NonNull;

import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import mad.location.manager.lib.Interfaces.LocationProviderInterface;

public class LocationDataProvider implements LocationProviderInterface {

    LocationProviderCallback m_locationProvider;
    boolean isStopped = true;

    public void setLocationProvider(LocationProviderCallback locationProvider) {
        m_locationProvider = locationProvider;
    }

    @Override
    public void providesLocation(Location location) {
        if(m_locationProvider != null && !isStopped) {
            m_locationProvider.onLocationAvailable(location);
        }
    }

    public void start() {
        isStopped = false;
    }

    public void stop() {
        isStopped = true;
    }
}
