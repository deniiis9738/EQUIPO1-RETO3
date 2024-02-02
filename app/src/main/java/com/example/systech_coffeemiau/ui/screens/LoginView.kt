import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.systech_coffeemiau.R
import com.example.systech_coffeemiau.ui.viewsmodels.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(loginViewModel: LoginViewModel) {
    val email by loginViewModel.email.observeAsState(initial = "")
    val password by loginViewModel.password.observeAsState(initial = "")
    val passwordVisibility by loginViewModel.passwordVisibility.observeAsState(initial = false)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.systechlogo),
            contentDescription = "iescaminas",
            modifier = Modifier.clip(CircleShape)
        )

        TextField(
            value = email,
            onValueChange = { loginViewModel.onEmailChanged(it) },
            enabled = true,
            placeholder = {
                Text(
                    text = "Email",
                    color = Color.Gray // Use a more neutral color
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray, // Change to a lighter background color
                focusedIndicatorColor = Color.Blue // Change to a more appealing focused indicator color
            ),
        )

        TextField(
            value = password,
            onValueChange = { loginViewModel.onPasswordChanged(it) },
            enabled = true,
            placeholder = {
                Text(
                    text = "Password",
                    color = Color.Gray // Use a more neutral color
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray, // Change to a lighter background color
                focusedIndicatorColor = Color.Blue // Change to a more appealing focused indicator color
            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val icon = loginViewModel.viewIcon()
                Icon(
                    imageVector = icon,
                    contentDescription = "Visible",
                    tint = Color.Gray, // Use a more neutral color
                    modifier = Modifier.clickable { loginViewModel.togglePasswordVisibility() }
                )
            }
        )

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier.align(Alignment.End),
        ) {
            Text(
                text = "¿Has olvidado tu contraseña?",
                color = Color.Blue
            )
        }

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = loginViewModel.changeColor(Color.Green, Color.Red)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue) // Change to a more appealing button color
        ) {
            Text(
                text = "Login In",
                color = Color.White // Change to a more contrasting text color
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .width(165.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "OR",
                color = Color.Blue
            )
            Spacer(modifier = Modifier.width(8.dp))

            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .width(165.dp)
            )
        }
    }
}
