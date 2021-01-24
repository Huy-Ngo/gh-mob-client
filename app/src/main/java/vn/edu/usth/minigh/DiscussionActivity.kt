/*
 * Copyright (C) 2020  Ngô Ngọc Đức Huy
 * This file is part of MiniGH.
 *
 * MiniGH is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MiniGH is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with MiniGH.  If not, see <https://www.gnu.org/licenses/>.
 */
package vn.edu.usth.minigh

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.*

class DiscussionActivity : BaseActivity(R.layout.activity_discussion) {
    private val r: Random
    private fun generateComment(i:Int): CommentFragment {
        // TODO: Empty this after the demo
        val fragment = vn.edu.usth.minigh.CommentFragment()
        val args = Bundle()
        val users = arrayOf("Huy-Ngo", "McSinyx", "Ming-Lonh", "PhuongPhg", "minhngo")
        args.putString("username", users[r.nextInt(users.size)])
        if (r.nextFloat() > 0.5) {
            args.putString("content", this.resources.getString(R.string.lorem_long))
        } else {
            args.putString("content", this.resources.getString(R.string.lorem_short))
        }
        fragment.arguments = args
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val title = intent.getStringExtra("title")
        val ghname = findViewById<View>(R.id.discussTitle) as TextView
        ghname.text = title

        val descrip = intent.getStringExtra("description")
        val content = findViewById<View>(R.id.discussDescription) as TextView
        content.text = descrip

        val nComments = 7
        for (i in 0 until nComments) {
            val fragment: Fragment = generateComment(i)
            supportFragmentManager.beginTransaction().setReorderingAllowed(true).add(
                    R.id.comment_container, fragment
            ).commit()
        }

    }

    init {
        r = Random(123456)
    }
}