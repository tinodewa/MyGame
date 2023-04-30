package hit.project.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import hit.project.mygame.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int totalPower = 0, jobType = 0, classType = 0, itemType = 0, jobPower = 0,
            classPower = 0, itemPower = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Glide.with(this).load(R.drawable.warrior).into(binding.ivPict);

        binding.rgJob.setOnCheckedChangeListener((radioGroup, i) -> {
            if (binding.rbJobOne.isChecked()) {
                setJob(1);
                jobType = 1;
                classType = 0;
                binding.rgClass.clearCheck();
            } else if (binding.rbJobTwo.isChecked()) {
                setJob(2);
                jobType = 2;
                classType = 0;
                binding.rgClass.clearCheck();
            } else if (binding.rbJobThree.isChecked()) {
                setJob(3);
                jobType = 3;
                classType = 0;
                binding.rgClass.clearCheck();
            }
        });

        binding.rgClass.setOnCheckedChangeListener((radioGroup, i) -> {
            if (binding.rbClassOne.isChecked()) {
                setClass(1);
                classType = 1;
            } else if (binding.rbClassTwo.isChecked()) {
                setClass(2);
                classType = 2;
            }
        });

        binding.cbAttack.setOnCheckedChangeListener((compoundButton, b) -> {
            if (compoundButton.isChecked()) {
                itemType = 1;
            }
        });
        binding.cbDefence.setOnCheckedChangeListener((compoundButton, b) -> {
            if (compoundButton.isChecked()) {
                itemType = 2;
            }
        });
        binding.cbASPD.setOnCheckedChangeListener((compoundButton, b) -> {
            if (compoundButton.isChecked()) {
                itemType = 3;
            }
        });
        binding.cbHP.setOnCheckedChangeListener((compoundButton, b) -> {
            if (compoundButton.isChecked()) {
                itemType = 4;
            }
        });

        binding.btnProcess.setOnClickListener(v -> {
            if (binding.etNamaKar.getText().toString().isEmpty() || jobType == 0 || classType == 0 || itemType == 0) {
                Toast.makeText(this, "Mohon lengkapi pilihan disamping!", Toast.LENGTH_SHORT).show();
            } else {
                if (jobType == 1) {
                    jobPower = 12000;
                    if (classType == 1) {
                        classPower = 5000;
                    } else if (classType == 2) {
                        classPower = 7000;
                    }
                } else if (jobType == 2) {
                    jobPower = 13000;
                    if (classType == 1) {
                        classPower = 4000;
                    } else if (classType == 2) {
                        classPower = 6000;
                    }
                } else if (jobType == 3) {
                    jobPower = 10000;
                    if (classType == 1) {
                        classPower = 3500;
                    } else if (classType == 2) {
                        classPower = 5000;
                    }
                }

                if (itemType == 1) {
                    itemPower = 10000;
                } else if (itemType == 2) {
                    itemPower = 8000;
                } else if (itemType == 3) {
                    itemPower = 6000;
                } else if (itemType == 4) {
                    itemPower = 15000;
                }

                totalPower = jobPower + classPower + itemPower;

                binding.tvNamaKarakter.setText(binding.etNamaKar.getText().toString());
                binding.tvJobPower.setText(String.valueOf(jobPower));
                binding.tvClassPower.setText(String.valueOf(classPower));
                binding.tvItemPower.setText(String.valueOf(itemPower));
                binding.tvInitPower.setText(String.valueOf(totalPower));
                binding.tvTotalPower.setText(String.valueOf(totalPower));

            }
        });
    }

    private void setJob(int job) {
        if (job == 1) {
            binding.rbClassOne.setText("Sword Master");
            binding.rbClassTwo.setText("Mercenary");
            Glide.with(this).load(R.drawable.warrior).into(binding.ivPict);
        } else if (job == 2) {
            binding.rbClassOne.setText("Bow Master");
            binding.rbClassTwo.setText("Acrobat");
            Glide.with(this).load(R.drawable.archer).into(binding.ivPict);
        } else if (job == 3) {
            binding.rbClassOne.setText("Paladin");
            binding.rbClassTwo.setText("Priest");
            Glide.with(this).load(R.drawable.cleric).into(binding.ivPict);
        }
    }

    private void setClass(int jobClass) {
        if (jobType == 1) {
            if (jobClass == 1) {
                Glide.with(this).load(R.drawable.warrior_swordmaster).into(binding.ivPict);
            } else if (jobClass == 2) {
                Glide.with(this).load(R.drawable.warrior_mercenary).into(binding.ivPict);
            }
        } else if (jobType == 2) {
            if (jobClass == 1) {
                Glide.with(this).load(R.drawable.archer_bowmaster).into(binding.ivPict);
            } else if (jobClass == 2) {
                Glide.with(this).load(R.drawable.archer_acrobat).into(binding.ivPict);
            }
        } else if (jobType == 3) {
            if (jobClass == 1) {
                Glide.with(this).load(R.drawable.cleric_paladin).into(binding.ivPict);
            } else if (jobClass == 2) {
                Glide.with(this).load(R.drawable.cleric_priest).into(binding.ivPict);
            }
        }
    }
}