package putriiiiiuta.androidlima.latihanchapterdelapan.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import putriiiiiuta.androidlima.latihanchapterdelapan.R
import android.annotation.SuppressLint
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import putriiiiiuta.androidlima.latihanchapterdelapan.room.Notes
import putriiiiiuta.androidlima.latihanchapterdelapan.vm.ViewModelNotes
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    @SuppressLint("NewApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val current = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
        val formatted = current.format(formatter)

        btnTambahNote.setOnClickListener {
            val judul = editJudul.text.toString()
            val isi = editIsi.text.toString()
            tambah( judul, isi, formatted)

        }

    }

    private fun tambah (judul :String, isi : String, tanggal : String){
        val viewModel = ViewModelProvider(requireActivity())[ViewModelNotes::class.java]

        GlobalScope.launch {
            viewModel.insertNoteLive(
                Notes(null, judul, isi, tanggal, "harian")
            )
            activity?.runOnUiThread {
                Toast.makeText(requireContext(), "BERHASIL MENAMBAHKAN NOTE", Toast.LENGTH_LONG).show()
            }

        }


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}