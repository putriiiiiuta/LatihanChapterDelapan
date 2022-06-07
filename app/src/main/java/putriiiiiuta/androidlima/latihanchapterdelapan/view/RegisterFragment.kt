package putriiiiiuta.androidlima.latihanchapterdelapan.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import putriiiiiuta.androidlima.latihanchapterdelapan.R
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import putriiiiiuta.androidlima.latihanchapterdelapan.room.User
import putriiiiiuta.androidlima.latihanchapterdelapan.room.UserDatabase
import putriiiiiuta.androidlima.latihanchapterdelapan.vm.ViewModelUser

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnDaftar.setOnClickListener {
            val username = editUsername1.text.toString()
            val email = editEmail1.text.toString()
            val password = editPassword1.text.toString()
            val password2 = editPassword2.text.toString()
            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && password2.isNotEmpty()){
                daftarUser(username, email, password, password2)
            }else{
                Toast.makeText(requireContext(), "Isi semua inputan", Toast.LENGTH_LONG).show()

            }
        }
    }

    private fun daftarUser(username : String, email : String, password : String, password2: String){
        val userDb = UserDatabase.getInstance(requireContext())

        val viewModel = ViewModelProvider(requireActivity())[ViewModelUser::class.java]
        if (password ==password2){
            GlobalScope.launch {
                viewModel.registerLive(User(null, username, email, password))
                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "Berhasil membuat akun", Toast.LENGTH_LONG).show()
                    startActivity(Intent(requireContext(), MainActivity::class.java))
                }
            }
        }else{
            Toast.makeText(requireContext(), "Konfirmasi password tidak sesuai", Toast.LENGTH_LONG).show()
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}