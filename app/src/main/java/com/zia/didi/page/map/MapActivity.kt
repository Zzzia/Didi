package com.zia.didi.page.map

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.amap.api.location.AMapLocation
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener
import com.amap.api.maps.CameraUpdateFactory
import com.amap.api.maps.LocationSource
import com.amap.api.maps.model.MyLocationStyle
import com.zia.didi.R
import kotlinx.android.synthetic.main.activity_map.*

class MapActivity : AppCompatActivity(), LocationSource, AMapLocationListener {

    private var locationClient: AMapLocationClient? = null
    private var locationChangedListener: LocationSource.OnLocationChangedListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        map.onCreate(savedInstanceState)
        setMap()
    }

    private fun setMap() {
        val myLocationStyle = MyLocationStyle()
        myLocationStyle.strokeColor(Color.WHITE)//圆形边框颜色
        myLocationStyle.radiusFillColor(Color.argb(40, 169, 70, 142))//圆形的填充颜色
        myLocationStyle.strokeWidth(1.0f)// 设置圆形的边框粗细
        map.map.myLocationStyle = myLocationStyle
        map.map.moveCamera(CameraUpdateFactory.zoomTo(16f))
        map.map.setLocationSource(this@MapActivity)
        map.map.uiSettings.isMyLocationButtonEnabled = false
        map.map.isMyLocationEnabled = true
    }

    override fun deactivate() {
        locationClient?.stopLocation()
        locationClient?.onDestroy()
        locationClient = null
    }

    override fun activate(p0: LocationSource.OnLocationChangedListener?) {
        locationChangedListener = p0
        if (locationClient == null) {
            val locationOption = AMapLocationClientOption()
            locationOption.locationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy
            locationOption.interval = 2000

            locationClient = AMapLocationClient(this@MapActivity)
            locationClient?.setLocationListener(this@MapActivity)
            locationClient?.setLocationOption(locationOption)
            locationClient?.startLocation()
        }

    }

    override fun onLocationChanged(p0: AMapLocation?) {
        locationChangedListener?.onLocationChanged(p0)
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        map.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        map.onDestroy()
        super.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        map.onLowMemory()
    }
}
