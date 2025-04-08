package online.asaphmwangi.garimpya

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VehicleAdapter(private val vehicleList: List<VehicleDetails>) : RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>()

{

    class VehicleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val carImageView: ImageView =itemView.findViewById(R.id.vehicle_image)
        val carNameView: TextView =itemView.findViewById(R.id.vehicle_name)
        val carPriceView: TextView = itemView.findViewById(R.id.vehicle_price)
        val carLocationView: TextView = itemView.findViewById(R.id.vehicle_location)
        val carYearView: TextView = itemView.findViewById(R.id.vehicle_year)
        val carMileageView: TextView = itemView.findViewById(R.id.vehicle_mileage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.product_design_one, parent, false)
        return VehicleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return vehicleList.size

    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val vehicleList =vehicleList[position]
        holder.carImageView.setImageResource(vehicleList.carImage)
        holder.carNameView.text= vehicleList.carName
        holder.carPriceView.text = vehicleList.carPrice
        holder.carLocationView.text = vehicleList.carLocation
        holder.carYearView.text =vehicleList.carYear
        holder.carMileageView.text =vehicleList.carMileage

    }
}