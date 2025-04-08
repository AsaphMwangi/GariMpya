package online.asaphmwangi.garimpya

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var vehicleAdapter: VehicleAdapter
    private lateinit var vehicleList: List<VehicleDetails>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
       init(view)
        return view
    }
    private fun init(view: View)
    {
        topPicksList(view)
        sedanList(view)
        otherVehiclesList(view)
    }

    private fun topPicksList(view: View)
    {
        recyclerView = view.findViewById(R.id.today_pick_recycler)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView. HORIZONTAL, false)


        vehicleList = listOf(VehicleDetails(R.drawable.car_blue,
            "Bugatti",
            "$3000",
            "Nairobi",
            "2023",
            "3000km"),VehicleDetails(R.drawable.car_black,
            "Lamborghini",
            "$5000",
            "Mombasa",
            "2024",
            "1000km"),
            VehicleDetails(R.drawable.car_blue,
                "Bugatti",
                "$3000",
                "Nairobi",
                "2023",
                "3000km"),VehicleDetails(R.drawable.car_black,
                "Lamborghini",
                "$5000",
                "Mombasa",
                "2024",
                "1000km"))

        vehicleAdapter = VehicleAdapter(vehicleList)
        recyclerView.adapter =vehicleAdapter
    }
    private fun sedanList(view: View)
    {
        recyclerView = view.findViewById(R.id.sedan_recycler)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView. HORIZONTAL, false)


        vehicleList = listOf(VehicleDetails(R.drawable.car_blue,
            "Bugatti",
            "$3000",
            "Nairobi",
            "2023",
            "3000km"),VehicleDetails(R.drawable.car_black,
            "Lamborghini",
            "$5000",
            "Mombasa",
            "2024",
            "1000km"),
            VehicleDetails(R.drawable.car_blue,
                "Bugatti",
                "$3000",
                "Nairobi",
                "2023",
                "3000km"),VehicleDetails(R.drawable.car_black,
                "Lamborghini",
                "$5000",
                "Mombasa",
                "2024",
                "1000km"))

        vehicleAdapter = VehicleAdapter(vehicleList)
        recyclerView.adapter =vehicleAdapter
    }
    private fun otherVehiclesList(view: View)
    {

        recyclerView = view.findViewById(R.id.other_recommendation_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView. HORIZONTAL, false)


        vehicleList = listOf(VehicleDetails(R.drawable.car_blue,
            "Bugatti",
            "$3000",
            "Nairobi",
            "2023",
            "3000km"),VehicleDetails(R.drawable.car_black,
            "Lamborghini",
            "$5000",
            "Mombasa",
            "2024",
            "1000km"),
            VehicleDetails(R.drawable.car_blue,
                "Bugatti",
                "$3000",
                "Nairobi",
                "2023",
                "3000km"),VehicleDetails(R.drawable.car_black,
                "Lamborghini",
                "$5000",
                "Mombasa",
                "2024",
                "1000km"))

        vehicleAdapter = VehicleAdapter(vehicleList)
        recyclerView.adapter =vehicleAdapter
    }

}
