package bank.service;

import bank.model.Account;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class AccountJSONStream implements JSONStream<List<Account>> {

    @Override
    public List<Account> read(File file) throws IOException {
        return new Gson().fromJson(
                new FileReader(file),
                new TypeToken<List<Account>>() {
                }.getType());
    }

    @Override
    public void write(List<Account> accounts, File file) throws IOException {
        Files.write(file.toPath(), new Gson().toJson(accounts,
                new TypeToken<List<Account>>() {
                }.getType()).getBytes());
    }
}
