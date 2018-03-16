package com.asf.wallet.di;

import com.asf.wallet.interact.FetchGasSettingsInteract;
import com.asf.wallet.interact.FindDefaultWalletInteract;
import com.asf.wallet.repository.GasSettingsRepositoryType;
import com.asf.wallet.repository.TokenRepositoryType;
import com.asf.wallet.repository.WalletRepositoryType;
import com.asf.wallet.router.ConfirmationRouter;
import com.asf.wallet.util.TransferParser;
import com.asf.wallet.viewmodel.SendViewModelFactory;
import dagger.Module;
import dagger.Provides;
import io.reactivex.subjects.PublishSubject;

@Module public class SendModule {
  @Provides SendViewModelFactory provideSendViewModelFactory(
      FindDefaultWalletInteract findDefaultWalletInteract, ConfirmationRouter confirmationRouter,
      FetchGasSettingsInteract fetchGasSettingsInteract, TransferParser transferParser) {
    return new SendViewModelFactory(findDefaultWalletInteract, fetchGasSettingsInteract,
        confirmationRouter, transferParser);
  }

  @Provides ConfirmationRouter provideConfirmationRouter() {
    return new ConfirmationRouter(PublishSubject.create());
  }

}
