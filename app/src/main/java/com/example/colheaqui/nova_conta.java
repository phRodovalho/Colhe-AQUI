package com.example.colheaqui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class nova_conta extends AppCompatActivity {

    private boolean validar(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            /*int validarEmail = email.toString().indexOf("@");
            if (validarEmail > 0) {
                isEmailIdValid = true;
            }*/
            isEmailIdValid = true;
        }
        return isEmailIdValid;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_nova_conta);

        final EditText nome = findViewById(R.id.Nome);
        final EditText email = findViewById(R.id.Emaill);
        final EditText senha = findViewById(R.id.Senha);
        final EditText rua = findViewById(R.id.Rua);
        final EditText numero = findViewById(R.id.numero);
        final EditText bairro = findViewById(R.id.bairro);
        Button btnConta = findViewById(R.id.btnCriar);
        Boolean Validar = true;

        //mascara cep - mask
        final EditText cep = (EditText) findViewById(R.id.cep);
        cep.addTextChangedListener(Mask.insert("#####-###", cep));

        //mascara telefone - mask
        final EditText telefone = (EditText) findViewById(R.id.telefone);
        telefone.addTextChangedListener(Mask.insert("(##)#####-####", telefone));

            btnConta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        if (nome.length() > 0 && validar(email.toString()) == true && senha.length() > 0 && rua.length() > 0 && numero.length() > 0 && bairro.length() > 0) {
                          Intent it = new Intent(nova_conta.this, Menu.class);
                          startActivity(it);
                        }else{
                            if (nome.length() <= 0) {
                                nome.setError("Nome Completo");
                                nome.requestFocus();
                            }
                            if (validar(email.toString()) == false) {
                                email.setError("E-mail invalido");
                                email.requestFocus();

                            }
                            if (senha.length() < 6) {
                                senha.setError("Senha deve ter 6 ou mais caracteres");
                                senha.requestFocus();
                            }
                            if (telefone.length() < 11) {
                                telefone.setError("Telefone invalido");
                                telefone.requestFocus();
                            }
                            if (rua.length() <= 0) {
                                rua.setError("*");
                                rua.requestFocus();
                            }
                            if (numero.length() <= 0) {
                                numero.setError("*");
                                numero.requestFocus();
                            }
                            if (bairro.length() <= 0) {
                                bairro.setError("*");
                                bairro.requestFocus();
                            }
                            if (cep.length() < 8) {
                                cep.setError("CEP tem 8 digitos");
                                cep.requestFocus();
                            }
                        }
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(), "Dados incompletos", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

